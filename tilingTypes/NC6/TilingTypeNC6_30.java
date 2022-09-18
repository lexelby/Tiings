package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_30
   extends TilingType
{
   public TilingTypeNC6_30(){
      super( "NC6-30", 6, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{210};
      paramDef = new int[]{ 65};
      paramName = new String[]{"Angle"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 3,2, 0,2,3, 0},
            {1, 0,5, 0,0,1, 0},
            {1, 2,1, 2,1,2, 0},

            {0, 4,5, 2,4,5, 1},
            {0, 3,2, 4,2,3, 1},
            {1, 0,5, 4,0,1, 1},
            {1, 2,1, 6,1,2, 1},
      };
      info = "a=b=c=d=e\nB=D\nB+C=360\n2A+B=360\n(E+F=A)";
   }
   
   public void recalcBase(double[] paramValues) {
      double ln = 0.5;
      double b = getParam(paramValues, 0);
      double ang = 90-b/2;

      double c = ln * Math.cos( ang * DEG2RAD );
      double s = ln * Math.sin( ang * DEG2RAD );
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,  c, -s);
      baseTile.setPoint(2,2*c,  0);
      baseTile.setPoint(3,3*c, -s);
      baseTile.setPoint(4,4*c,  0);
      baseTile.setPoint(5,  0, ln);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(4)-tiles[3].getX(5);
      offsets[1] = tiles[0].getY(4)-tiles[3].getY(5);
      offsets[2] = tiles[0].getX(5)-tiles[4].getX(1);
      offsets[3] = tiles[0].getY(5)-tiles[4].getY(1);
   }
}