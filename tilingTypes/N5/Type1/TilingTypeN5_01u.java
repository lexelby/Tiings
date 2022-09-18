package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01u
   extends TilingType
{
   public TilingTypeN5_01u(){
      super( "N5-1u", 5, SymmetryType.p2 );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{180,100};
      paramDef = new int[]{100, 65};
      paramName = new String[]{ "Angle", "Relative length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,0,1, 1},
            {0, 0,4, 1,0,4, 0},
            {1, 0,1, 2,0,1, 1},
            };
      info = "d=c+e\nA=90\nC+D=180\n2B+C=360\n(B+E=270)";
   }

   public void recalcBase(double[] paramValues) {
      double ln1 = 1;
      double ln2 = ln1 * getParam(paramValues,1)/100;
      double ln3 = ln1- ln2;
      double e = paramValues[0];
      double a = 180-e;
      double d = 180-e/2;
      double ln4;
      if( ln2-ln3>1e-4 ){
         double diag = calcSide(ln1,ln2-ln3,e);
         double ang2 = d - calcAngle(ln2-ln3,diag,ln1);
         ln4 = diag * Math.cos(ang2*DEG2RAD);
      }else if( ln3-ln2> 1e-4 ){
         double diag = calcSide(ln1,ln3-ln2,a);
         double ang2 = 180-d - calcAngle(ln1,diag, ln3-ln2);
         ln4 = diag * Math.cos(ang2*DEG2RAD);
      }else{
         ln4 = ln1 * Math.cos((d-a)*DEG2RAD);
      }

      double x3 =       ln2 * Math.cos( (d-90) * DEG2RAD);
      double y3 = ln4 + ln2 * Math.sin( (d-90) * DEG2RAD);
      double x2 = x3  + ln1 * Math.cos( (d+e-270) * DEG2RAD);
      double y2 = y3  + ln1 * Math.sin( (d+e-270) * DEG2RAD);
      double x1 = x2  + ln3 * Math.cos( (d-270) * DEG2RAD);
      double y1 = y2  + ln3 * Math.sin( (d-270) * DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4,  0,ln4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(1)-tiles[2].getX(2);
      offsets[1] = tiles[0].getY(1)-tiles[2].getY(2);
      offsets[2] = tiles[0].getX(4)-tiles[2].getX(3);
      offsets[3] = tiles[0].getY(4)-tiles[2].getY(3);
   }
}
