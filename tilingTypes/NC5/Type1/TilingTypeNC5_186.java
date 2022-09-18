package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_186
   extends TilingType
{
   public TilingTypeNC5_186(){
      super( "NC5-186", 5, SymmetryType.p2 );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{180,100};
      paramDef = new int[]{ 80, 40};
      paramName = new String[]{ "Angle", "Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 0,4, 0,4,0, 0},
            {1, 3,4, 0,0,1, 1},
            {1, 0,4, 2,4,0, 1},
      };
      info = "e=c+d\nb=c+e\nB+C=180\nC+D=360\n(A+B+E=180)";
   }
   
   public void recalcBase(double[] paramValues) {
      double lnb = 1.0;
      double lnd = lnb * getParam(paramValues,1)/100;
      double lnc = (lnb - lnd)/2;
     
      double b = getParam(paramValues,0);
      double c = Math.cos(b * DEG2RAD);
      double s = Math.sin(b * DEG2RAD);

      baseTile.setPoint(0, 0, 0);
      baseTile.setPoint(1, lnb, 0);
      baseTile.setPoint(2, lnb -lnc*c, lnc*s);
      baseTile.setPoint(3, lnb-lnd -lnc*c, lnc*s);
      baseTile.setPoint(4, lnb-lnd -lnb*c, lnb*s);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[1].getX(3);
      offsets[1] = tiles[0].getY(2)-tiles[1].getY(3);
      offsets[2] = tiles[0].getX(4)-tiles[3].getX(3);
      offsets[3] = tiles[0].getY(4)-tiles[3].getY(3);
   }
}
