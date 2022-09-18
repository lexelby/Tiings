package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_02d
   extends TilingType
{
   public TilingTypeNC6_02d(){
      super( "NC6-2d", 6, SymmetryType.pgg );

      paramMin = new int[]{-90};
      paramMax = new int[]{ 90};
      paramDef = new int[]{ 20};
      paramName = new String[]{"Angle"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 3,5, 0,0,2, 1},
            {1, 0,1, 0,0,5, 0},
            {1, 0,1, 1,0,5, 1},

            {1, 4,3, 2,3,4, 0},
            {0, 0,5, 4,0,1, 0},
            {0, 3,5, 5,0,2, 1},
            {1, 0,1, 6,0,5, 1},
      };
      info = "a=b=c=d=e=f\nA=90\nF=90\nB+E=360\n(C+D=180)";
   }

   public void recalcBase(double[] paramValues) {
      double w = .5;
      double a = getParam(paramValues, 0);
      double c = w * Math.cos(a * DEG2RAD);
      double s = w * Math.sin(a * DEG2RAD);
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,  w,  0);
      baseTile.setPoint(2,w+c,  s);
      baseTile.setPoint(3,w+c,w+s);
      baseTile.setPoint(4,  w,w  );
      baseTile.setPoint(5,  0,w  );
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(5)-tiles[1].getX(2);
      offsets[1] = tiles[0].getY(5)-tiles[1].getY(2);
      offsets[2] = tiles[3].getX(5)-tiles[7].getX(4);
      offsets[3] = tiles[3].getY(5)-tiles[7].getY(4);
   }
}