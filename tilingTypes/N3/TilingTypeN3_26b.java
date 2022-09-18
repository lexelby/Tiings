package tilingTypes.N3;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN3_26b
   extends TilingType
{
   public TilingTypeN3_26b(){
      super( "N3-26b", 4, SymmetryType.p2 );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{180,100};
      paramDef = new int[]{ 90, 40};
      paramName = new String[]{ "Angle", "Offset" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 3,0, 0,2,1, 0},
            {2, 3,1, 1,1,3, 0},
            
            {2, 1,0, 2,0,1, 0},
            {1, 1,3, 3,3,1, 0},
            {0, 2,1, 4,3,0, 0},
     };
      info = "2a=c\n(A+B+C=180)";
      labels = new int[]{0,1,-1,2};
   }

   public void recalcBase(double[] paramValues) {
      double h = .5;
      double c = h * Math.cos(paramValues[0]*DEG2RAD);
      double s = h * Math.sin(paramValues[0]*DEG2RAD);
      double w = c + Math.sqrt(4*h*h-s*s);
      double f = getParam( paramValues,1)/100.;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,  w,  0);
      baseTile.setPoint(2,f*w+(1-f)*c,  s*(1-f));
      baseTile.setPoint(3,  c,  s);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(1)-tiles[0].getX(3);
      offsets[1] = tiles[0].getY(1)-tiles[0].getY(3);
      offsets[2] = tiles[5].getX(0)-tiles[0].getX(1);
      offsets[3] = tiles[5].getY(0)-tiles[0].getY(1);
   }
}
