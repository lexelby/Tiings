package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_43
   extends TilingType
{
   public TilingTypeNC6_43(){
      super( "NC6-43", 6, SymmetryType.p6 );

      paramMin = new int[]{  0,  0,  0};
      paramMax = new int[]{100,100,100};
      paramDef = new int[]{ 50, 60, 20};
      paramName = new String[]{"Relative Length", "X", "Y"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {1, 5,0, 0,5,4, 0},
            {1, 5,0, 1,5,4, 0},
            {1, 5,0, 2,5,4, 0},
            {1, 5,0, 3,5,4, 0},
            {1, 5,0, 4,5,4, 0},

            {0, 4,1, 0,1,4, 0},
            {0, 4,1, 1,1,4, 0},
            {0, 4,1, 2,1,4, 0},
            {0, 4,1, 3,1,4, 0},
            {0, 4,1, 4,1,4, 0},
            {0, 4,1, 5,1,4, 0},
      };
      info = "b+f=2a\nc=e\nA=120\nF=60\nC+D=360\n(B+E=180)";
   }
   
   public void recalcBase(double[] paramValues) {
      double ln = 0.5;
      double h = ln * Math.sqrt(3)/2;
      double r = getParam(paramValues, 0)/100;
      double ln1 = ln * 2 * r;
      double ln2 = ln * 2 - ln1;
      
      double x = ln * 2 * getParam(paramValues, 1)/100;
      double y = getParam(paramValues, 2)/100;
      
      baseTile.setPoint(0,   0,  0);
      baseTile.setPoint(1, ln1,  0);
      baseTile.setPoint(2,  x+y*-ln/2, y*h);
      baseTile.setPoint(3, 2*ln-x+(1-y)*-ln/2, (1-y)*h);
      baseTile.setPoint(4, -ln/2+ln2, h);
      baseTile.setPoint(5, -ln/2, h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(0)-tiles[9].getX(5);
      offsets[1] = tiles[0].getY(0)-tiles[9].getY(5);
      offsets[2] = tiles[2].getX(0)-tiles[11].getX(5);
      offsets[3] = tiles[2].getY(0)-tiles[11].getY(5);
   }
}